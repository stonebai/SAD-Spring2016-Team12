package models;
import java.util.List;


/**
 * Created by alicesypark on 4/26/16.
 */
public class HTMLAdapter {

    public HTMLAdapter() {

    }

    public String getUserName(Comment comment) {
        return comment.getUserName();
    }

    public String getUserName(Workflow wf) {
        return wf.getUserName();
    }

    public String getUserName(Reply r, String s) {
        if (s.equals("from")) {
            return r.getFromUserName();
        } else {
            return r.getToUserName();
        }
    }

    public String getContent(Suggestion s) {
        return s.getsContent();
    }

    public String getContent(Comment c) {
        return c.getContent();
    }

    // public String getContent(List<Suggestion> s, int i) {
    //     return s.get(i).getsContent();
    // }

    public String getContent(List<Comment> comments, int i) {
        return comments.get(i).getContent();
    }

    public String getContent(Reply r) {
        return r.getContent();
    }

    public String getContent(Workflow wf, String str) {
        if (str.equals("shortDesc")) {
            return wf.getShortWfDesc();
        } else if (str.equals("title")) {
            return wf.getWfTitle();
        } else if (str.equals("category")) {
            return wf.getWfCategory();
        } else if (str.equals("viewCount")) {
            return Long.toString(wf.getWfViewCount());
        }
        return "";
    }

    public String get(Workflow wf, String str) {
        if (str.equals("username")) {
            return wf.getUserName();
        } else if (str.equals("shortDesc")) {
            return wf.getShortWfDesc();
        } else if (str.equals("title")) {
            return wf.getWfTitle();
        } else if (str.equals("category")) {
            return wf.getWfCategory();
        } else if (str.equals("viewCount")) {
            return Long.toString(wf.getWfViewCount());
        } else if (str.equals("desc")) {
            return wf.getWfDesc();
        } else if (str.equals("input")) {
            return wf.getInputString();
        } else if (str.equals("code")) {
            return wf.getWfCode();
        }
        return "";
    }


}
