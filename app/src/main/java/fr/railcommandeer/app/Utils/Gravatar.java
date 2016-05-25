package fr.railcommandeer.app.Utils;

/**
 * fr.railcommandeer.app.Utils
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class Gravatar {
    public static String gravatarUrl(String email) {
        return "http://www.gravatar.com/avatar/" + MD5.md5(email)+".jpg";
    }
}
