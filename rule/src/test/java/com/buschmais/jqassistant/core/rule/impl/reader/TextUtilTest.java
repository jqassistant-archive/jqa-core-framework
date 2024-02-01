package com.buschmais.jqassistant.core.rule.impl.reader;

import org.junit.jupiter.api.Test;

import static com.buschmais.jqassistant.core.rule.impl.reader.TextUtil.removeIndent;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void spacesWithinText() {
        assertThat(removeIndent("text text\ttext")).isEqualTo("text text\ttext");
    }
    @Test
    public void leadingAndTrailingSpaces() {
        assertThat(removeIndent("text")).isEqualTo("text");
    }
    @Test
    public void multiLineText(){
        assertThat(removeIndent("text\ntext")).isEqualTo("text\ntext");
    }
    @Test
    public void tabsText(){
        assertThat(removeIndent("text\ttext")).isEqualTo("text\ttext");
    }
    @Test
   public void feedText(){
       assertThat(removeIndent("text\ftext")).isEqualTo("text\ftext");
    }
    @Test
    public void singleQuoteText(){
        assertThat(removeIndent("text ' text")).isEqualTo("text ' text");
    }

    @Test
    public void backSlashText(){
        assertThat(removeIndent("text \\ text")).isEqualTo("text \\ text");
   }




}
