package com.example.integrazione.hw1;

import java.util.Scanner;

public class wrap {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Inserisci la stringa di input: ");
                String str = scanner.nextLine();

                System.out.print("Inserisci la stringa per il wrapping: ");
                String wrapWith = scanner.nextLine();

                String wrappedString = wrapIfMissing(str, wrapWith);
                System.out.println("Stringa wrappata: " + wrappedString);

                scanner.close();
        }

        public static boolean isEmpty(String str) {
                return str == null || str.isEmpty();
        }

/**
 * <p>
 * Wraps a string with a string if that string is missing from the start or end of the given string.
 * </p>
 *
 * <p>A new {@code String} will not be created if {@code str} is already wrapped.</p>
 *
 * <pre>
 * wrapIfMissing(null, *)         = null
 * wrapIfMissing("", *)           = ""
 * wrapIfMissing("ab", null)      = "ab"
 * wrapIfMissing("ab", "x")       = "xabx"
 * wrapIfMissing("ab", "\"")      = "\"ab\""
 * wrapIfMissing("\"ab\"", "\"")  = "\"ab\""
 * wrapIfMissing("ab", "'")       = "'ab'"
 * wrapIfMissing("'abcd'", "'")   = "'abcd'"
 * wrapIfMissing("\"abcd\"", "'") = "'\"abcd\"'"
 * wrapIfMissing("'abcd'", "\"")  = "\"'abcd'\""
 * wrapIfMissing("/", "/")  = "/"
 * wrapIfMissing("a/b/c", "/")  = "/a/b/c/"
 * wrapIfMissing("/a/b/c", "/")  = "/a/b/c/"
 * wrapIfMissing("a/b/c/", "/")  = "/a/b/c/"
 * </pre>
 *
 * @param str
 *            the string to be wrapped, may be {@code null}
 * @param wrapWith
 *            the string that will wrap {@code str}
 * @return the wrapped string, or {@code null} if {@code str==null}
 * @since 3.5
 */
public static String wrapIfMissing(final String str, final String wrapWith) {
        if (isEmpty(str) || isEmpty(wrapWith)) {
        return str;
        }

final boolean wrapStart = !str.startsWith(wrapWith);
final boolean wrapEnd = !str.endsWith(wrapWith);

        if (!wrapStart && !wrapEnd) {
        return str;
        }

final StringBuilder builder = new StringBuilder(str.length() + wrapWith.length() + wrapWith.length());

        if (wrapStart) {
        builder.append(wrapWith);
        }

        builder.append(str);

        if (wrapEnd){
        builder.append(wrapWith);
        }
        return builder.toString();
        }

}
