package app;

public class Yeah {

    public static String out(final Date start, final Date end, final int room, final int money, final String person) {
        return String.format("Room %s#    --- Booked from %s - %s to %s || %s$\n", (room + 1), start.toString(),
                end.toString(), person, money);
    }

}
