/*******************************************************************************
 * @preserve Copyright (c) 2014 Sense Inc. as an unpublished
 * work. Neither this material nor any portion hereof may be copied or
 * distributed without the express written consent of Sense Inc.
 *
 * This material also contains proprietary and confidential information
 * of Sense Inc. and its suppliers, and may not be used by or
 * disclosed to any person, in whole or in part, without the prior written
 * consent of Sense Inc.
 ******************************************************************************/

package com.sense.common.model;

/**
 * Created by brianenochson on 7/9/14.
 */
/**
 * Representation of state in the United States.
 */
public enum State
{
    ALABAMA("Alabama", "AL"),
    ALASKA("Alaska", "AK"),
    ARIZONA("Arizona", "AZ"),
    ARKANSAS("Arkansas", "AR"),
    CALIFORNIA("California", "CA"),
    COLORADO("Colorado", "CO"),
    CONNECTICUT("Connecticut", "CT"),
    DELAWARE("Delaware", "DE"),
    DISTRICT_OF_COLUMBIA("District of Columbia", "DC"),
    FLORIDA("Florida", "FL"),
    GEORGIA("Georgia", "GA"),
    HAWAII("Hawaii", "HI"),
    IDAHO("Idaho", "ID"),
    ILLINOIS("Illinois", "IL"),
    INDIANA("Indiana", "IN"),
    IOWA("Iowa", "IA"),
    KANSAS("Kansas", "KS"),
    LOUISIANA("Louisiana", "LA"),
    MAINE("Maine", "ME"),
    MARYLAND("Maryland", "MD"),
    MASSACHUSETTS("Massachusetts", "MA"),
    MICHIGAN("Michigan", "MI"),
    MINNESOTA("Minnesota", "MN"),
    MISSISSIPPI("Mississippi", "MS"),
    MISSOURI("Missouri", "MO"),
    MONTANA("Montana", "MT"),
    NEBRASKA("Nebraska", "NE"),
    NEVADA("Nevada", "NV"),
    NEW_HAMPSHIRE("New Hampshire", "NH"),
    NEW_JERSEY("New Jersey", "NJ"),
    NEW_MEXICO("New Mexico", "NM"),
    NORTH_CAROLINA("North Carolina", "NC"),
    NORTH_DAKOTA("North Dakota", "ND"),
    NEW_YORK("New York", "NY"),
    OHIO("Ohio", "OH"),
    OKLAHOMA("Oklahoma", "OK"),
    OREGON("Oregon", "OR"),
    PENNSYLVANIA("Pennsylvania", "PA"),
    RHODE_ISLAND("Rhode Island", "RI"),
    SOUTH_CAROLINA("South Carolina", "SC"),
    SOUTH_DAKOTA("South Dakota", "SD"),
    TENNESSEE("Tennessee", "TN"),
    TEXAS("Texas", "TX"),
    UTAH("Utah", "UT"),
    VERMONT("Vermont", "VT"),
    VIRGINIA("Virginia", "VA"),
    WASHINGTON("Washington", "WA"),
    WEST_VIRGINIA("West Virginia", "WV"),
    WISCONSIN("Wisconsin", "WI"),
    WYOMING("Wyoming", "WY"),
    UNKNOWN("Unknown", "UK");

    private String stateName;

    private String stateAbbreviation;

    State(final String newStateName, final String newStateAbbreviation)
    {
        this.stateName = newStateName;
        this.stateAbbreviation = newStateAbbreviation;
    }

    public String getStateName()
    {
        return this.stateName;
    }

    public String getStateAbbreviation()
    {
        return this.stateAbbreviation;
    }

    public static State fromAbbreviation(final String candidateAbbreviation)
    {
        State match = UNKNOWN;
        if (candidateAbbreviation != null && candidateAbbreviation.length() == 2)
        {
            final String upperAbbreviation = candidateAbbreviation.toUpperCase();
            for (final State state : State.values())
            {
                if (state.stateAbbreviation.equals(upperAbbreviation))
                {
                    match = state;
                }
            }
        }
        return match;
    }
}