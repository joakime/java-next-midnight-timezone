package net.erdfelt.tz;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NextMidnight
{
    public static void main(String[] args)
    {
        List<ZonedDateTime> zones = new ArrayList<>();
        
        for (String zone : ZoneId.getAvailableZoneIds())
        {
            ZoneId zoneId = ZoneId.of(zone);
            zones.add(ZonedDateTime.now(zoneId));
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("kk:mm:ss yyyy-MM-dd z");
        
        zones.stream()
                .map((z) -> String.format("%-37s [%s]", formatter.format(z), z.getZone().getId()))
                .sorted(Comparator.naturalOrder())
                .forEach((z) -> System.out.println(z));
    }
}
