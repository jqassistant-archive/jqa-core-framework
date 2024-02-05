package com.buschmais.jqassistant.core.rule.impl.reader;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.buschmais.jqassistant.core.rule.impl.reader.TextUtil.removeIndent;
import static org.assertj.core.api.Assertions.*;

/**
 * multi-line text
 * leading/trailing empty lines (with any spaces/tabs)
 * leading tabs and spaces
 * keep indent in multi-line strings
 * extra characters:
 * new line \n
 * tab \t
 * feed \f
 * single quote \'
 * backslash \\
 */
public class TextUtilTest {



    @Disabled
    @Test
    public void leadingAndTrailingSpaces() {
        assertThat(removeIndent("text")).isEqualTo("text");
    }
    @Disabled
    @Test
    public void multiLineText(){
        assertThat(removeIndent("text\ntext")).isEqualTo("text\ntext");
    }

    @Disabled
    @Test
    public void tabsText(){
        assertThat(removeIndent("text\ttext")).isEqualTo("text\ttext");
    }

    @Test
    public void extraWhiteSpaces(){
        assertThat(removeIndent("                 text to believe \ntext to work                      ")).isEqualTo(" text to believe \ntext to work ");
    }
    @Test
    public void extraLines(){
        assertThat(removeIndent("         \ntext\n\ntext  \n           ")).isEqualTo("text\n\ntext  \n");
    }

    @Test
    public void emptyText(){
        assertThat(removeIndent("")).isEqualTo("");
    }

    @Test
    public void moveTextLeft(){
        assertThat(removeIndent("        text\n  text    text\n    text    text\n  text    text\n        text")).isEqualTo("      text\ntext    text\n  text    text\ntext    text\n      text");
    }

}
