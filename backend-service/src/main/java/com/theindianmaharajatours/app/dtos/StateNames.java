package com.theindianmaharajatours.app.dtos;

import com.theindianmaharajatours.app.dtos.Enum.States;

import java.util.HashMap;
import java.util.Map;

public class StateNames
{

    private static Map<States, String> STATE_NAMES = new HashMap<>();

    public StateNames()
    {
        STATE_NAMES.put(States.ANDRAPRADESH, "ANDRA PRADESH");
        STATE_NAMES.put(States.DELHI, "DELHI");
        STATE_NAMES.put(States.GOA, "GOA");
        STATE_NAMES.put(States.HIMACHALPRADESH, "HIMACHAL PRADESH");
        STATE_NAMES.put(States.JAMMUKASHMIR, "JAMMU KASHMIR");
        STATE_NAMES.put(States.KARNATAKA, "KARNATAKA");
        STATE_NAMES.put(States.MAHARASHTRA, "MAHARASHTRA");
        STATE_NAMES.put(States.NORTHEAST, "NORTHEAST");
        STATE_NAMES.put(States.PUNJAB, "PUNJAB");
        STATE_NAMES.put(States.RAJASTHAN, "RAJASTHAN");
        STATE_NAMES.put(States.TAMILNADU, "TAMILNADU");
        STATE_NAMES.put(States.UTTARPRADESH, "UTTAR PRADESH");
        STATE_NAMES.put(States.UTTRAKHAND, "UTTRAKHAND");
        STATE_NAMES.put(States.WESTBENGAL, "WEST BENGAL");
        STATE_NAMES.put(States.KERALA, "KERELA");

    }

    public static String getStateName(States state)
    {
        return STATE_NAMES.get(state).toString();
    }

}
