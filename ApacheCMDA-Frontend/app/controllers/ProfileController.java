package controllers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.JsonNode;
import models.SearchResult;
import models.Workflow;
import play.api.mvc.*;
import play.mvc.Result;
import util.APICall;
import util.Constants;
import views.html.*;
import play.mvc.Controller;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 * Created by gavin on 11/19/15.
 */
public class ProfileController extends Controller {
    private static enum FollowType {
        FOLLOWEE, FOLLOWER
    }

    public static boolean notpass() {
        if (session("id") == null) {
            return true;
        }
        return false;
    }

    private static List<User> getFollow(Long id, FollowType f) {
        String queryApi = Constants.NEW_BACKEND
                + (f == FollowType.FOLLOWEE ? "users/getFollowees/" : "users/getFollowers/")
                + id.toString();
        JsonNode response = APICall.callAPI(queryApi);
        if (response.has("error"))
            return new ArrayList<User>();
        List<User> result = new ArrayList<User>();
        String key = (f == FollowType.FOLLOWEE ? "followees" : "followers");
        JsonNode arr = response.get(key);
        for (JsonNode entity: arr) {
            User u = new User();
            JsonNode user = entity.get("User");
            u.setId(Long.parseLong(user.get("id").textValue()));
            u.setUserName(user.get("userName").textValue());
            u.setEmail(user.get("email").textValue());
            u.setAvatar(user.get("avatar").textValue());
            result.add(u);
        }
        return result;
    }

    private static List<User> getFriends(Long id)
    {
        String queryApi = Constants.NEW_BACKEND
                + "users/getFriends/userId/" + id.toString();
        JsonNode response = APICall.callAPI(queryApi);
        if (response.has("error"))
            return new ArrayList<User>();
        List<User> result = new ArrayList<User>();
        if (response.get("friends")==null) return result;
        for (JsonNode entityn: response.get("friends")) {
            JsonNode entity = entityn.get("User");
            User u = new User();
            u.setId(Long.parseLong(entity.get("id").textValue()));
            u.setUserName(entity.get("userName").textValue());
            u.setAvatar(entity.get("avatar").textValue());
            result.add(u);
        }
        return result;
    }

    public static Result profile(Long id) {
        if (notpass()) return redirect(routes.Application.login());
        JsonNode response = APICall.callAPI(Constants.NEW_BACKEND + "users/getprofile/" + id.toString() + "/json");
        if (response == null || response.has("error")) {
            return redirect(routes.Application.login());
        }

        String res_user = response.get("userName").textValue();
        String res_email = "";
        Long res_id = response.get("id").asLong();
        try {
            res_email = response.get("email").textValue();
        } catch (Exception e) {
            res_email = "";
        }

        User user = new User();
        user.setUserName(res_user);
        user.setEmail(res_email);
        user.setId(res_id);
        user.setAvatar(response.get("avatar").textValue());

        List<User> followers = ProfileController.getFollow(id, FollowType.FOLLOWER);
        List<User> followees = ProfileController.getFollow(id, FollowType.FOLLOWEE);

        List<User> myfriends = ProfileController.getFriends(Long.parseLong(session("id")));
        boolean isFriend = false;
        for (User entry : myfriends)
        {
            if (entry.getId() == id)
                isFriend = true;
        }
        boolean isFollower = false;
        boolean isFollowee = false;
        Long myId = Long.parseLong(session("id"));
        for (User entry : followers)
        {
            if (entry.getId() == myId)
                isFollower = true;
        }
        for (User entry : followees)
        {
            if (entry.getId() == myId)
                isFollowee = true;
        }

        List<Workflow> wf = getMyWorkflows(id);

        return ok(profile.render(user, followers, followees, myfriends, session("username"), session("id"), isFollower, isFollowee, isFriend));
    }

    public static List<Workflow> getMyWorkflows(Long id)
    {
        JsonNode response = APICall.callAPI(Constants.NEW_BACKEND + "workflow/getuser/" + id.toString() + "/json");
        List<Workflow> wf = new ArrayList<Workflow>();
        return wf;
    }

    public static Result sendRequest(Long id)
    {
        if (notpass()) return redirect(routes.Application.login());
        String query = Constants.NEW_BACKEND
                + "users/sendFriendRequest/sender/"
                + session("id")
                + "/receiver/"
                + id.toString();
        JsonNode response = APICall.callAPI(query);
        if (response == null || response.has("error")) {
            flash("error", "Cannot send friend request.");
            return redirect(routes.ProfileController.profile(id));
        }
        flash("success", "Friend Request Sent!.");
        return redirect(routes.ProfileController.profile(id));
    }

    public static Result deleteFriend(Long id)
    {
        if (notpass()) return redirect(routes.Application.login());
        String query = Constants.NEW_BACKEND
                + "users/deleteFriend/userId/"
                + session("id")
                + "/friendId/"
                + id.toString();
        JsonNode response = APICall.callAPI(query);
        if (response == null || response.has("error")) {
            flash("error", "Cannot delete friend.");
            return redirect(routes.ProfileController.profile(id));
        }
        flash("success", "Friend deleted!.");
        return redirect(routes.ProfileController.profile(id));
    }

    public static Result follow(Long id) {
        if (notpass()) return redirect(routes.Application.login());
        String followQuery = Constants.NEW_BACKEND
                + "users/follow/followerId/"
                + session("id")
                + "/followeeId/"
                + id.toString();
        JsonNode response = APICall.callAPI(followQuery);
        if (response == null || response.has("error")) {
            return redirect(routes.Application.login());
        }
        return redirect(routes.ProfileController.profile(id));
    }

    public static Result unfollow(Long id) {
        if (notpass()) return redirect(routes.Application.login());
        String unfollowQuery = Constants.NEW_BACKEND
                + "users/unfollow/followerId/"
                + session("id")
                + "/followeeId/"
                + id.toString();
        JsonNode response = APICall.callAPI(unfollowQuery);
        if (response == null || response.has("error")) {
            return redirect(routes.Application.login());
        }
        return redirect(routes.ProfileController.profile(id));
    }
}
