package com.example.gianni.sdpprototype.Responses;

import com.example.gianni.sdpprototype.Models.Student;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vasil on 24/9/2016.
 */

public class StudentResponse
{
    @SerializedName("Result")
    private Student student;
    private Boolean isSuccess;
    private Object displayMessage;

    /**
     *
     * @return
     * The student
     */
    public Student getStudent() {
        return student;
    }

    /**
     *
     * @param student
     * The Student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     *
     * @return
     * The isSuccess
     */
    public Boolean getIsSuccess() {
        return isSuccess;
    }

    /**
     *
     * @param isSuccess
     * The IsSuccess
     */
    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     *
     * @return
     * The displayMessage
     */
    public Object getDisplayMessage() {
        return displayMessage;
    }

    /**
     *
     * @param displayMessage
     * The DisplayMessage
     */
    public void setDisplayMessage(Object displayMessage) {
        this.displayMessage = displayMessage;
    }
}
