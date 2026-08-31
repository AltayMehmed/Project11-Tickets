package repository;

import model.CinemaData;

public class FileManager {
    private final XmlRepository repository = new XmlRepository();
    public void save(String path, CinemaData data) throws Exception {
        repository.save(path, data);
    }
    public void load(String path, CinemaData data) throws Exception {
        repository.load(path, data);
    }
}
