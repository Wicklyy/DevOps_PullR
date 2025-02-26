import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyUnsortedListTest {

    // On test la suppression et l'ajout d'éléments
    @Test
    void testPopSurListeVide() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        assertThrows(EmptyListException.class, () -> list.pop());  // Vérifie que pop() échoue sur une liste vide
    }

    // Détection d'une erreur
    @Test
    void testPopLastSurListeVide() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        assertThrows(EmptyListException.class, () -> list.popLast());  // Vérifie que popLast() échoue sur une liste vide
    }

    @Test
    void testRemoveAvecIndiceInvalide() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));  // Vérifie que remove() échoue sur un index hors limites
    }

    @Test
    void testPrependEtAppend() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.prepend(1);
        list.append(2);
        list.append(3);

        assertEquals(3, list.size());  // La taille doit être 3
        assertEquals(1, list.pop());   // Le premier élément doit être 1
        assertEquals(2, list.pop());   // Le deuxième élément doit être 2
        assertEquals(3, list.pop());   // Le dernier élément doit être 3
    }

    // On test l'insertion d'un élément avec des indices valides et invalides
    @Test
    void testInsererAPositionValide() {
        UnsortedList<Integer> list = MyUnsortedList.of(1,2,3);
        list.insert(4,1);
        assertEquals(4, list.remove(1)); // On vérifie qu'on a bien ajouté 4 en tête de liste (position 1)
    }

    @Test
    void testInsererAPositionInvalide() {
        UnsortedList<Integer> list = MyUnsortedList.of(1,2,3);
        assertThrows(IndexOutOfBoundsException.class, () ->list.insert(4,-1)); // On vérifie qu'insérer un élément à une position non valide lève une exception
    }

    // On test la fonctionnalité d'égalité entre les listes
    @Test
    void testEgaliteAvecListesIdentiques() {
        UnsortedList<Integer> liste1 = MyUnsortedList.of(1, 2, 3);
        UnsortedList<Integer> liste2 = MyUnsortedList.of(1, 2, 3);
        assertTrue(liste1.equals(liste2));  // Vérifie que les deux listes sont égales
    }

    @Test
    void testEgaliteAvecListesDifferent() {
        UnsortedList<Integer> liste1 = MyUnsortedList.of(1, 2, 3);
        UnsortedList<Integer> liste2 = MyUnsortedList.of(3, 2, 1);
        assertFalse(liste1.equals(liste2));  // Vérifie que les deux listes sont différentes
    }

    @Test
    void testEgaliteAvecListesDeTailleDifferent() {
        UnsortedList<Integer> liste1 = MyUnsortedList.of(1, 2, 3);
        UnsortedList<Integer> liste2 = MyUnsortedList.of(1, 2);
        assertFalse(liste1.equals(liste2));  // Vérifie que les listes de tailles différentes ne sont pas égales
    }

    // On test la fonctionnalité toString
    @Test
    void testToString() {
        UnsortedList<Integer> emptyList = MyUnsortedList.of();
        assertEquals("MyUnsortedList { size = 0, [] }", emptyList.toString());
    
        UnsortedList<Integer> oneElementList = MyUnsortedList.of(1);
        assertEquals("MyUnsortedList { size = 1, [1] }", oneElementList.toString());
    
        UnsortedList<Integer> multiElementList = MyUnsortedList.of(1, 2, 3);
        assertEquals("MyUnsortedList { size = 3, [1, 2, 3] }", multiElementList.toString());
    }

    @Test
    void testListeAvecUnSeulElement() {
        UnsortedList<Integer> liste = MyUnsortedList.of(1);
        assertEquals(1, liste.size());  // La taille doit être 1
        assertEquals(1, liste.pop());   // Le seul élément de la liste doit être 1
    }

    @Test
    void testListeAvecElementsIdentiques() {
        UnsortedList<Integer> liste = MyUnsortedList.of(1, 1, 1);
        assertEquals(3, liste.size());  // La taille doit être 3
        assertEquals(1, liste.pop());   // Le premier élément doit être 1
        assertEquals(1, liste.pop());   // Le deuxième élément doit être 1
        assertEquals(1, liste.pop());   // Le dernier élément doit être 1
    }
    
    // Détection d'une erreur
    @Test
    void testAppendNull() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2);
        assertThrows(NullPointerException.class, () -> list.append(null));
    }

    // Erreur détecté! -> PB: La taille ne se mettait pas à jour!
    @Test
    void testRemoveAUnePositionSpecifique() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
        assertEquals(2, list.remove(1));
        assertEquals("MyUnsortedList { size = 3, [1, 3, 4] }", list.toString());
    }
    
    @Test
    void testInsertAUnePositionInvalide() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(4, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(4, 4));
    }


    @Test
    void testOrderAppend() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals("MyUnsortedList { size = 3, [1, 2, 3] }", list.toString());
    }

    @Test
    void testOrderPrepend() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);
        assertEquals("MyUnsortedList { size = 3, [1, 2, 3] }", list.toString());
    }

    // Test sur un grand nombre d'éléments
    @Test
    void testGrandeListe() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        for (int i = 0; i < 100000; i++) {
            list.append(i);
        }
        assertEquals(100000, list.size());
    }
}
