package com.buschmais.jqassistant.core.rule.api.model;

import com.buschmais.jqassistant.core.rule.api.configuration.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class DescriptionTest {

    @Mock
    private Rule rule;

    private RuleSet ruleSet;

    @BeforeEach
    void readRuleSetXML() throws RuleException {
        this.ruleSet = RuleSetTestHelper.readRuleSet("/descriptions.xml", rule);
        this.ruleSet = RuleSetTestHelper.readRuleSet("/yaml/descriptions.yaml", rule);
    }

    /**
     * in Stream<Argument>  we enter the ID of the xml file. then we enter the expectations from the description.
     * @return ID , EXPECTATION
     */
    public static Stream<Arguments> getIdAndResultOfConstraints() {
        return Stream.of(
                Arguments.of("test:WithoutDescription", null),
                Arguments.of("test:EmptyDescription", ""),
                Arguments.of("test:SingleLineDescription", "When he arrived at the station, the bus had already left."),
                Arguments.of("test:MultiMixEmptyLineDescription", "When he arrived at the station,\n\nthe bus had already left."));
    }
    public static Stream<Arguments> getIdAndResultOfConcepts() {
        return Stream.of(
                Arguments.of("test:WithoutDescription", null),
                Arguments.of("test:EmptyDescription", ""),
                Arguments.of("test:SingleLineDescription", "Cal took a long, deep breath, struggling to control his own emotions."),
                Arguments.of("test:MultiMixEmptyLineDescription", "Cal took a long, deep breath,\n\nstruggling to control his own emotions."));
    }

    /**
     * here we apply all rules to the description from xml file !
     * We split it into 2 Conditions : 1.Concept
     *                                 2.Constrain
     *
     * @param ID       we get it from the Stream<Argument>
     * @param expected we get it from the Stream<Argument>
     */
    @ParameterizedTest
    @MethodSource
    void getIdAndResultOfConcepts(String ID, String expected) throws RuleException {
        Concept concept = this.ruleSet.getConceptBucket().getById(ID);
        assertThat(concept.getDescription()).isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource
    void getIdAndResultOfConstraints(String ID, String expected) throws RuleException {
        Constraint constraint = this.ruleSet.getConstraintBucket().getById(ID);
        assertThat(constraint.getDescription()).isEqualTo(expected);
    }
}
