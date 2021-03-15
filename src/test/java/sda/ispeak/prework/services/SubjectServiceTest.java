package sda.ispeak.prework.services;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SubjectServiceTest {

    private final SubjectService sut = new SubjectService();

    @Test
    void shouldFetchSubjects() {

        List<String> result = sut.getAllSubjects();

        assertThat(result).hasSize(3);
    }
}
