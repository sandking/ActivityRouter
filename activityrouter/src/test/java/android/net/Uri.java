package android.net;

import java.net.URI;

/**
 * Minimal stub of Android's {@code Uri} for unit testing on the JVM.
 */
public class Uri {
    private final URI uri;

    private Uri(URI uri) {
        this.uri = uri;
    }

    public static Uri parse(String str) {
        return new Uri(URI.create(str));
    }

    public String getScheme() {
        return uri.getScheme();
    }

    public String getHost() {
        return uri.getHost();
    }

    public String getPath() {
        return uri.getPath();
    }

    public String getQueryParameter(String name) {
        if (uri.getQuery() == null) {
            return null;
        }
        for (String pair : uri.getQuery().split("&")) {
            String[] nv = pair.split("=", 2);
            if (nv.length == 2 && nv[0].equals(name)) {
                return nv[1];
            }
        }
        return null;
    }
}
