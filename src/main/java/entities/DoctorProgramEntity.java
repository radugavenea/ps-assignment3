package entities;

import java.sql.Time;

/**
 * Created by radu on 05.05.2017.
 */
public class DoctorProgramEntity {

    private int id;
    private Time startsAtProgram;
    private Time endsAtProgram;
    private int userId;

    public DoctorProgramEntity(int id, Time startsAtProgram, Time endsAtProgram, int userId) {
        this.id = id;
        this.startsAtProgram = startsAtProgram;
        this.endsAtProgram = endsAtProgram;
        this.userId = userId;
    }

    public DoctorProgramEntity(Time startsAtProgram, Time endsAtProgram, int userId) {
        this.startsAtProgram = startsAtProgram;
        this.endsAtProgram = endsAtProgram;
        this.userId = userId;
    }

    public DoctorProgramEntity(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStartsAtProgram() {
        return startsAtProgram;
    }

    public void setStartsAtProgram(Time startsAtProgram) {
        this.startsAtProgram = startsAtProgram;
    }

    public Time getEndsAtProgram() {
        return endsAtProgram;
    }

    public void setEndsAtProgram(Time endsAtProgram) {
        this.endsAtProgram = endsAtProgram;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
