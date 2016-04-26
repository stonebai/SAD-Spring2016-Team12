package models;

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

    public String getContent(Reply r) {
        return r.getContent();
    }


}
