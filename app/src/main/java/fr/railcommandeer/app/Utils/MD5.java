package fr.railcommandeer.app.Utils;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * Created by fernandomartinez on 6/19/15.
 */
public class MD5 {

    public static String md5(String string) {
        return new String(Hex.encodeHex(DigestUtils.md5(string)));
    }
}