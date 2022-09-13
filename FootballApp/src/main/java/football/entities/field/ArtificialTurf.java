package football.entities.field;

public class ArtificialTurf extends BaseField{

    private static final int ARTIFICIAL_TURF_INITIAL_CAPACITY = 150;

    public ArtificialTurf(String name) {
        super(name, ARTIFICIAL_TURF_INITIAL_CAPACITY);
    }
}
