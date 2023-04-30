import java.io.*;
import java.time.LocalDate;

import java.util.*;

public class OTTShow implements Serializable {

    private static final String EXTENT_PERSISTENCE_PATH = "Data/extent.txt";

    //extent
    private static final Set<OTTShow> extent = new HashSet<>();

    //Class attribute
    private static int MIN_SHOW_NAME_LENGTH = 5;

    //Mandatory
    private String showName;

    //Optional
    private String showDescription;
    private LocalDate airDate;

    //Complex Attribute
    private OTTShowSettings ottShowSettings = new OTTShowSettings(false, false);

    //Multi-Value Attribute
    private final Set<String> nameOfEpisodes = new HashSet<>();

    public OTTShow(String showName) {
        setShowName(showName);
        extent.add(this);
    }

    //Method Overloading
    public OTTShow(String showName, String showDescription, LocalDate airDate, OTTShowSettings ottShowSettings, String nameOfEpisode) {
        setOttShowSettings(ottShowSettings);
        setAirDate(airDate);
        setShowDescription(showDescription);
        setShowName(showName);
        addEpisodeName(nameOfEpisode);
        extent.add(this);
    }

    //Extent Persistence
    public static void saveExtent() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(EXTENT_PERSISTENCE_PATH))) {
            objectOutputStream.writeObject(extent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //load extent
    public static void loadExtent() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(EXTENT_PERSISTENCE_PATH))) {
            extent.addAll((Collection<? extends OTTShow>) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OTTShow show = (OTTShow) o;
        return Objects.equals(showName, show.showName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showName);
    }

    //Derived attribute
    public String getShowNameAirDate() throws Exception{
        if(showName == null || airDate == null){
            throw  new Exception("Show name or Air Date is missing");
        }
        if(ottShowSettings.getIsNotAvailable()){
            throw new Exception("Show isn't Available at the Platform");
        }
        return showName.toUpperCase(Locale.ROOT) + " " + airDate.toString();
    }

    //Class Method
    public static Optional<OTTShow> findByName(String showName){
        if(showName == null || invalidShowNameLength(showName.trim())){
            return Optional.empty();
        }
        return extent.stream().filter(x -> x.showName.equals(showName)).findAny();
    }

    public static OTTShow updateAirDate(String showName, LocalDate newAirDate){
        if(newAirDate == null || newAirDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Input Date must be a further date from Today");

        OTTShow show = OTTShow.findByName(showName).isPresent() ? OTTShow.findByName(showName).get() : null;
        assert show != null;
        show.setAirDate(newAirDate);
        System.out.println(show);
        return show;
    }

    public static void delete(OTTShow ottShow){
        if(ottShow != null){
            extent.remove(ottShow);
        }
    }

    public static void clear(){
        extent.clear();
    }


    private static boolean invalidShowNameLength(String showName) {
        return showName.length() < MIN_SHOW_NAME_LENGTH;
    }

    public static Set<OTTShow> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        if (showName == null) {
            throw new IllegalArgumentException("Show name Cannot be null");
        }

        String trimmedShowName = showName.trim();

        if(invalidShowNameLength(trimmedShowName)){
            throw new IllegalArgumentException("Invalid Show name Length");
        }
        if(findByName(trimmedShowName).isPresent()){
            throw new IllegalArgumentException("Show Already Exists");
        }
        this.showName = trimmedShowName;
    }

    public String getShowDescription() {
        return showDescription;
    }

    public void setShowDescription(String showDescription) {
        if(showDescription == null){
            this.showDescription = null;
            return;
        }

        String trimmedShowDescription = showDescription.trim();

        if(trimmedShowDescription.isBlank()){
            throw new IllegalArgumentException("Show Description should not be blank");
        }
        this.showDescription = trimmedShowDescription;
    }

    public LocalDate getAirDate() {
        return airDate;
    }

    public void setAirDate(LocalDate airDate) {
        if (airDate==null){
            throw new IllegalArgumentException("Air Date is required");
        }
        if(airDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Input Date must be a further date from Today");
        }
        this.airDate = airDate;
    }

    public OTTShowSettings getOttShowSettings() {
        return ottShowSettings;
    }

    public void setOttShowSettings(OTTShowSettings ottShowSettings) {
        if(ottShowSettings == null){
            throw new IllegalArgumentException("Show settings must not be Null");
        }
        this.ottShowSettings = ottShowSettings;
    }

    public Set<String> getNameOfEpisodes() {
        return Collections.unmodifiableSet(nameOfEpisodes);
    }

    public void addEpisodeName(String episodeName){
        if(episodeName == null || episodeName.isBlank()){
            throw new IllegalArgumentException("Episode node must not be null or Empty");
        }
        if(nameOfEpisodes.contains(episodeName)){
            throw new IllegalArgumentException("Episode already exists");
        }
        nameOfEpisodes.add(episodeName);
    }

    public void removeEpisodeName(String episodeName){
        if(episodeName == null || episodeName.isBlank()){
            throw new IllegalArgumentException("Episode node must not be null or Empty");
        }
        if(!nameOfEpisodes.contains(episodeName)){
            throw new IllegalArgumentException("Episode does not exists");
        }
        nameOfEpisodes.remove(episodeName);
    }

    public static int getMinShowNameLength() {
        return MIN_SHOW_NAME_LENGTH;
    }

    public static void setMinShowNameLength(int minShowNameLength) {
        if(minShowNameLength < 1){
            throw new IllegalArgumentException("minShowNameLength must be 1 or greater");
        }
        MIN_SHOW_NAME_LENGTH = minShowNameLength;
    }


    @Override
    public String toString() {
        return "OTTShow{" +
                "showName='" + showName + '\'' +
                ", showDescription='" + showDescription + '\'' +
                ", airDate=" + airDate +
                ", ottShowSettings=" + ottShowSettings +
                ", nameOfEpisodes=" + nameOfEpisodes +
                '}';
    }
}
