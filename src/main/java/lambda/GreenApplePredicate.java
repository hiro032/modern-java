package lambda;

public class GreenApplePredicate implements ApplePredicate{
    @Override
    public boolean filter(Apple apple) {
        return apple.color == Color.GREEN;
    }
}
