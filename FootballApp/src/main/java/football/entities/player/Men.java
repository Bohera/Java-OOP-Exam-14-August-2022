package football.entities.player;

public class Men extends BasePlayer{

    private static final double MEN_INITIAL_KG = 85.50;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
        setKg(MEN_INITIAL_KG);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 145);
    }
}
