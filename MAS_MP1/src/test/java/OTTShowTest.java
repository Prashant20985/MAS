import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OTTShowTest {

    @Before
    public void setUp(){
        OTTShow.clear();
    }
    
    @Test
    public void constructor() {
        assertThrows(IllegalArgumentException.class, () -> new OTTShow(null));
        assertThrows(IllegalArgumentException.class, () -> new OTTShow(""));
        assertThrows(IllegalArgumentException.class, () -> new OTTShow("               "));
        assertThrows(IllegalArgumentException.class, () -> new OTTShow("S"));
        OTTShow show = new OTTShow("   showName   \n ");
        assertEquals("showName", show.getShowName());
        assertThrows(IllegalArgumentException.class, () -> new OTTShow("showName"));
    }

    @Test
    public void setShowDescription(){
        OTTShow show = new OTTShow("showName");
        assertThrows(IllegalArgumentException.class, () -> show.setShowDescription(""));
        assertThrows(IllegalArgumentException.class, () -> show.setShowDescription("            "));
        show.setShowDescription("   Description   \n  ");
        assertEquals("Description", show.getShowDescription());
        show.setShowDescription(null);
        assertNull(show.getShowDescription());
    }

    @Test
    public void setAirDate(){
        OTTShow show = new OTTShow("showName");
        assertThrows(IllegalArgumentException.class, () -> show.setAirDate(null));
        LocalDate localDate = LocalDate.now().plusDays(1);
        show.setAirDate(localDate);
        assertEquals(localDate, show.getAirDate());
    }

    @Test
    public void getShowNameAirDate(){
        OTTShowSettings ottShowSettings = new OTTShowSettings(false, true);
        OTTShow show = new OTTShow("showName");
        assertThrows(Exception.class, show::getShowNameAirDate);
        LocalDate localDate = LocalDate.now().plusDays(1);
        OTTShow show1 = new OTTShow("showName1", "Descriptionn", localDate, ottShowSettings, "E1:S1");

        try {
            assertEquals("SHOWNAME1 "+ localDate, show1.getShowNameAirDate());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getExtentAndDelete(){
        OTTShow show = new OTTShow("showName");
        OTTShow show1 = new OTTShow("showName1");

        Set<OTTShow> extent = OTTShow.getExtent();
        assertEquals(2, extent.size());
        assertTrue(extent.contains(show));
        assertTrue(extent.contains(show1));
        OTTShow.delete(show1);

        assertEquals(1, extent.size());
        assertTrue(extent.contains(show));
        assertFalse(extent.contains(show1));

    }

    @Test
    public void clear(){
        OTTShow show = new OTTShow("showName");
        OTTShow show1 = new OTTShow("showName1");

        Set<OTTShow> extent = OTTShow.getExtent();
        assertEquals(2, extent.size());
        OTTShow.clear();
        Set<OTTShow> extent2 = OTTShow.getExtent();
        assertEquals(0, extent2 .size());
    }

    @Test
    public void findByShowName() {
        OTTShow show = new OTTShow("showName");
        OTTShow show1 = new OTTShow("showName1");
        assertFalse(OTTShow.findByName(null).isPresent());
        assertFalse(OTTShow.findByName("").isPresent());

        Optional<OTTShow> showOptional = OTTShow.findByName("showName");
        assertTrue(showOptional.isPresent());
        assertEquals("showName", showOptional.get().getShowName());
    }

    @Test
    public void UpdateAirDate(){
        OTTShowSettings ottShowSettings = new OTTShowSettings(false, true);
        OTTShow show = new OTTShow("showName", "Description", LocalDate.now().plusDays(2), ottShowSettings, "S1:EP1");
        assertThrows(IllegalArgumentException.class, () -> OTTShow.updateAirDate(show.getShowName(), LocalDate.now().minusDays(1)));
        OTTShow updatedShow = OTTShow.updateAirDate(show.getShowName(), LocalDate.now().plusDays(2));
        assertEquals(LocalDate.now().plusDays(2), updatedShow.getAirDate());
    }

    @Test
    public void addAndRemoveNameOfEpisodes(){
        OTTShow show = new OTTShow("showName");
        String [] episodes = {"S1:E1","S1:E2","S1:E3"};
        for(String e : episodes){
            show.addEpisodeName(e);
        }
        System.out.println(show);
        assertEquals(3, show.getNameOfEpisodes().size());
        assertThrows(IllegalArgumentException.class,() -> show.addEpisodeName(episodes[0]));
        assertThrows(IllegalArgumentException.class,() -> show.removeEpisodeName("S1:E10"));
        show.removeEpisodeName(episodes[0]);
        assertEquals(2, show.getNameOfEpisodes().size());
        String [] expectedEpisodes = {episodes[1], episodes[2]};
        assertEquals(Arrays.toString(expectedEpisodes), show.getNameOfEpisodes().toString());
    }

    @Test
    public void showSettings(){
        OTTShowSettings ottShowSettings = new OTTShowSettings(false, true);
        OTTShow show = new OTTShow(
                "ShowName",
                "showDescription",
                LocalDate.now().plusDays(1),
                ottShowSettings,
                "S1:EP1");

        assertTrue(show.getOttShowSettings().getIsPurchased());
        assertFalse(show.getOttShowSettings().getIsNotAvailable());

        show.getOttShowSettings().setNotAvailable(true);
        show.getOttShowSettings().setPurchased(false);

        assertFalse(show.getOttShowSettings().getIsPurchased());
        assertTrue(show.getOttShowSettings().getIsNotAvailable());
        System.out.println(show);
    }

    @Test
    public void saveAndLoadExtent(){
        OTTShow show = new OTTShow("showName");
        OTTShow show1 = new OTTShow("showName1");
        OTTShow.saveExtent();
        assertEquals(2, OTTShow.getExtent().size());
        OTTShow.clear();
        assertEquals(0, OTTShow.getExtent().size());
        OTTShow.loadExtent();
        assertEquals(2, OTTShow.getExtent().size());
        assertTrue(OTTShow.getExtent().contains(show));
        assertTrue(OTTShow.getExtent().contains(show1));
    }
}