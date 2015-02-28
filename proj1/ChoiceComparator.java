import java.util.*;

public class ChoiceComparator implements Comparator<Choice> {
    @Override
    public int compare(Choice c1, Choice c2) {
        return c1.weight > c2.weight ? -1 : c1.weight == c2.weight ? 0: 1;
    }
}
