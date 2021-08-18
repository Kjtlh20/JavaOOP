package com.gmail.dev.surovtsev.yaroslav;

public class Phone {
    private String name;
    private String vendor;
    private String number;
    private Network network;

    public Phone() {
    }

    public Phone(String name, String vendor, String number) {
        this.name = name;
        this.vendor = vendor;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void registerInNetwork(Network network) {
        boolean isRegistered = network.registerPhone(this);
        if (isRegistered) {
            setNetwork(network);
        }
    }

    public void callTo(String phoneNumberToCall) {
        String phoneNumberFromCall = getNumber();
        if (network == null || !network.checkPhoneNumberRegistration(phoneNumberFromCall)) {
            System.out.println("Phone number " + phoneNumberFromCall + " is not registered on the network");
            return;
        }
        if (!network.checkPhoneNumberRegistration(phoneNumberToCall)) {
            System.out.println("Phone number " + phoneNumberToCall + " is not registered on the network");
            return;
        }
        network.call(phoneNumberFromCall, phoneNumberToCall);
    }

    public void incomingCall(String incomingNumber) {
        String currPhoneNumber = getNumber();
        System.out.println("Incoming call from " + incomingNumber + " to " + currPhoneNumber);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                ", number='" + number + '\'' +
                ", network=" + network +
                '}';
    }
}
