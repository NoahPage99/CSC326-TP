#Feature: Create and view office visit
        #HCP should be able to document office visits
        #So that Patients and the HCPS can view past and upcomming Office Visits
        #
#Scenario Outline: No office Visits has been created
        #Given A Patient exist in iTrust2
        #When I log in as a patient
        #When I navigate to the View Office Visits page
        #Then <text> is displayed for Office Visits
        #
#Examples:
        #| text |
        #| No Office Visits found.|
        #
#Scenario Outline: Office Visits have been created
        #Given A Patient exist in iTrust2
        #And An HCP exists in iTrust2
        #When I log in as a patient
        #When I navigate to the View Office Visits page
        #Then the Office Visit is created
        #Then The Office Visit with all information shows
        #
#Examples:
        #| type                          | hcp                   |date             |time                |comments         |Status|
        #| General checkup               | Dr. James HCP         |03/20/21         |1:00pm              |Patient eyes hurt|Open  |
        #
#Scenario Outline: Patient views Office Visits
        #Given A Patient exist in iTrust2
        #And An HCP exists in iTrust2
        #And an Office Visit has been created
        #When I log in as a patient
        #When I navigate to the View Office Visits page
        #Then The Office Visit with all information shows
        #
#Examples:
        #| type                          | hcp                   |date             |time                |comments         |Status|
        #| General checkup               | Dr. James HCP         |03/20/21         |1:00pm              |Patient eyes hurt|Open  |
        #
#Scenario Outline: Invalid Office Visits
        #Given A Patient exist in iTrust2
        #And An HCP exists in iTrust2
        #And an Office Visit has been created
        #When I log in as a patient
        #When I navigate to the View Office Visits page
        #Then The Office Visit is not accepted
        #
#Examples:
        #| type                          | hcp                   |date             |time                |comments         |Status   |
        #| General checkup               | Dr. James HCP         |03/20/21         |1:00am              |Patient eyes hurt|invalid  |
        #
#Scenario Outline: Cancel Office Visit
        #Given A Patient exist in iTrust2
        #And An HCP exists in iTrust2
        #And an Office Visit has been created
        #When I log in as a patient
        #When I navigate to the View Office Visits page
        #Then The Office Visit with all information shows
        #Then reschedule the Office visit
        #
#Examples:
        #| type                          | hcp                   |date             |time                |comments         |Status|
        #| General checkup               | Dr. James HCP         |03/20/21         |1:00pm              |Patient eyes hurt|Rescheduled  |
        #| General checkup               | Dr. James HCP         |03/21/21         |1:00pm              |Patient eyes hurt|Open         |
