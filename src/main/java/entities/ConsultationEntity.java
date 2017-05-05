package entities;

import java.sql.Time;

/**
 * Created by radu on 05.05.2017.
 */
public class ConsultationEntity {

    private int id;
    private Time startsAtTime;
    private Time endsAtTime;
    private String doctorsName;
    private int userId;
    private int patientId;

    public ConsultationEntity(int id, Time startsAtTime, Time endsAtTime, String doctorsName, int userId, int patientId) {
        this.id = id;
        this.startsAtTime = startsAtTime;
        this.endsAtTime = endsAtTime;
        this.doctorsName = doctorsName;
        this.userId = userId;
        this.patientId = patientId;
    }

    public ConsultationEntity(Time startsAtTime, Time endsAtTime, String doctorsName, int userId, int patientId) {
        this.startsAtTime = startsAtTime;
        this.endsAtTime = endsAtTime;
        this.doctorsName = doctorsName;
        this.userId = userId;
        this.patientId = patientId;
    }

    public ConsultationEntity(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStartsAtTime() {
        return startsAtTime;
    }

    public void setStartsAtTime(Time startsAtTime) {
        this.startsAtTime = startsAtTime;
    }

    public Time getEndsAtTime() {
        return endsAtTime;
    }

    public void setEndsAtTime(Time endsAtTime) {
        this.endsAtTime = endsAtTime;
    }

    public String getDoctorsName() {
        return doctorsName;
    }

    public void setDoctorsName(String doctorsName) {
        this.doctorsName = doctorsName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
