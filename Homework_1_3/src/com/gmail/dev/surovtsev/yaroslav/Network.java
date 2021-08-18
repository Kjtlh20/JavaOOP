package com.gmail.dev.surovtsev.yaroslav;

import java.util.Arrays;

public class Network {
    private String name;
    private String[] phoneNumbers;
    private Phone[] phones;

    public Network() {
    }

    public Network(String name) {
        phoneNumbers = new String[10];
        phones = new Phone[10];
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Phone[] getPhones() {
        return phones;
    }

    public void setPhones(Phone[] phones) {
        this.phones = phones;
    }

    public boolean registerPhone(Phone phone) {
        String phoneNumber = phone.getNumber();
        boolean isRegistered = checkPhoneNumberRegistration(phoneNumber);
        if (isRegistered) {
            return true;
        }
        for (int i = 0; i < phoneNumbers.length; i++) {
            if (phoneNumbers[i] == null) {
                phoneNumbers[i] = phoneNumber;
                phones[i] = phone;
                isRegistered = true;
                break;
            }
        }
        return isRegistered;
    }

    public boolean checkPhoneNumberRegistration(String phoneNumber) {
        boolean isRegistered = false;
        for (int i = 0; i < phoneNumbers.length; i++) {
            if (phoneNumbers[i] != null && phoneNumbers[i].equals(phoneNumber)) {
                isRegistered = true;
                break;
            }
        }
        return isRegistered;
    }

    public void call(String phoneNumberFromCall, String phoneNumberToCall) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null && phones[i].getNumber().equals(phoneNumberToCall)) {
                phones[i].incomingCall(phoneNumberFromCall);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Network{" +
                "name='" + name + '\'' +
                ", phoneNumbers=" + Arrays.toString(phoneNumbers) +
                ", phones=" + Arrays.toString(phones) +
                '}';
    }
}
