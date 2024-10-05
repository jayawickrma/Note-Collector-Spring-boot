package lk.ijse.note_collector_V2.Exeptions;

public class DataPersistExeption extends RuntimeException{
    public DataPersistExeption() {
        super();
    }

    public DataPersistExeption(String message) {
        super(message);
    }

    public DataPersistExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
