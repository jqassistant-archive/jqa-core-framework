package com.buschmais.jqassistant.core.rule.impl.reader;

import org.junit.Test;

import static com.buschmais.jqassistant.core.rule.impl.reader.TextUtil.removeIndent;
import static org.assertj.core.api.Assertions.assertThat;

public class TextUtilTest {

    @Test
    public void leadingAndTrailingSpaces() {
        assertThat(removeIndent("  text  ")).isEqualTo("text");
    }


}
