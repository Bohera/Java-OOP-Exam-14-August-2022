package football.entities.field;

public class NaturalGrass extends BaseField{

    private static final int NATURAL_GRASS_INITIAL_CAPACITY = 250;

    public NaturalGrass(String name) {
        super(name, NATURAL_GRASS_INITIAL_CAPACITY);
    }
}
