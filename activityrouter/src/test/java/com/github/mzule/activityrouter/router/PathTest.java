package com.github.mzule.activityrouter.router;

import android.net.Uri;

/**
 * Simple tests for {@link Path} verifying hostless URIs are handled properly.
 */
public class PathTest {
    public static void main(String[] args) {
        testCreateHostless();
        testMatchHostless();
        System.out.println("All tests passed.");
    }

    private static void testCreateHostless() {
        Uri uri = Uri.parse("scheme:/path");
        Path path = Path.create(uri);
        if (!"".equals(path.next().value())) {
            throw new AssertionError("Expected empty host segment");
        }
        if (!"path".equals(path.next().next().value())) {
            throw new AssertionError("Incorrect path segment");
        }
    }

    private static void testMatchHostless() {
        Path format = Path.create(Uri.parse("helper://path"));
        Path link = Path.create(Uri.parse("scheme:/path"));
        if (!Path.match(format.next(), link.next().next())) {
            throw new AssertionError("Hostless URI should match format");
        }
    }
}
