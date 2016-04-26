package util;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by baishi on 4/26/16.
 */
public class PipeAndFilterCheck {
    public static boolean checkRequestBody(JsonNode json) {
        if (json == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkUserIdInJson(JsonNode json) {
        if (json.path("userID") == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkUserIdInJsonValid(JsonNode json) {
        if (!checkValidUserId(json.path("userID").asLong())) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkWfTagsInJson(JsonNode json) {
        if (json.path("wfTags") == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkWfContributorsInJson(JsonNode json) {
        if (json.path("wfContributors") == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkWfRelatedInJson(JsonNode json) {
        if (json.path("wfRelated") == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkWfIdInJson(JsonNode json) {
        if (json.path("wfID") == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkWfIdInJsonValid(JsonNode json) {
        if (!checkValidWfId(json.path("wfID").asLong())) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkId(Long id) {
        if (id == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkValidUserId(Long id) {
        if (RepoFactory.getRepo(Constants.USER_REPO).findOne(id) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkValidWfId(Long id) {
        if (RepoFactory.getRepo(Constants.WORKFLOW_REPO).findOne(id) == null) {
            return false;
        }
        else {
            return true;
        }
    }
}
