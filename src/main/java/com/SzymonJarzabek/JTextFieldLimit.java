package com.SzymonJarzabek;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Created by Szymon on 2017-06-12.
 */

/**
 * Klasa do tworzenia textfieldów o ograniczonej możliwości wprowadzania znaków
 */
public class JTextFieldLimit extends PlainDocument {
    private int limit;
    private boolean toUppercase = false;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString
            (int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= limit) {
            if (toUppercase) str = str.toUpperCase();
            super.insertString(offset, str, attr);
        }
    }
}