package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.repositories.PetRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Ten test sam zainicjowalem na bazie: https://www.baeldung.com/mockito-annotations
@RunWith(MockitoJUnitRunner.class)
class PetSDJpaServiceTest {

    PetRepository petRepository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    void setUp() {
    }

    //Z i bez @Mock notation przyklady
    //In the following example, we'll create a mocked ArrayList manually without using the @Mock annotation:
    @Test //To jest wziete z przykladow tylko
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

    //Now we'll do the same, but we'll inject the mock using the @Mock annotation:
    @Mock
    List<String> mockedList = Mockito.mock(ArrayList.class, "zero");
    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    //Note how in both examples, we're interacting
    // with the mock and verifying some of these interactions, just to make sure
    // that the mock is behaving correctly.

    // @Spy Annotation
    //Now let's see how to use the @Spy annotation to spy on an existing instance.
    //In the following example, we create a spy of a List without using the @Spy annotation:
    @Test
    public void whenNotUseSpyAnnotation_thenCorrect() {
        List<String> spyList = Mockito.spy(new ArrayList<String>());

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}