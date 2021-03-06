Feature: View and complete satisfaction surveys
	Patients and HCPs/Opthamologists should be able to view satisfaction surveys after completing an appointment
	So that general HCPs/Opthamologists and admins can review their performance

Scenario Outline: Patient has no surveys to complete
	Given A Patient exists in iTrust2
	When I log in as patient
	When I navigate to the Manage Surveys page
	Then no appointments show up



Scenario Outline: Complete satisfaction survey
	Given A Patient exists in iTrust2
	And An HCP exists in iTrust2
	When I log in as patient
	When I navigate to the Manage Appointment Requests page
	When I choose to complete a survey for a medical appointment
	Then The appointment request with updated

Examples:
	| timeWaitedWaitingRoom							| timeWaitedExaminationRoom				| satisfiedOfficeVisit			| satisfiedTreatment 		| notes 						|
	| 0												| 0 		        					| 6								| 6							| My brain still hurt					|
  
  
Scenario Outline: failed satisfaction survey
	Given A Patient exists in iTrust2
	And An HCP exists in iTrust2
	When I log in as patient
	When I navigate to the Manage Appointment Requests page
	When I choose to complete a survey for a medical appointment with error input
	Then The appointment request is not submitted and the form remains the same for editing.

Examples:
	| timeWaitedWaitingRoom							| timeWaitedExaminationRoom				| satisfiedOfficeVisit			| satisfiedTreatment 		| notes 						|
	| -5				| -5 		        | A	| B	| My brain still hurt					|

Scenario Outline: User Reviews satisfaction survey
	Given A Patient exists in iTrust2
	And An HCP exists in iTrust2
 	When The patient has been to a medical appointment and the patient has completed a satisfaction survey
	When I navigate to the Manage Surveys page
	Then I can review a survey 

Examples:
	| timeWaitedWaitingRoom							| timeWaitedExaminationRoom				| satisfiedOfficeVisit			| satisfiedTreatment 		| notes 						|
	| 0				| 0 		        | 6	| 6	| My brain still hurt					|


Scenario Outline: Approve appointment request as an HCP
	Given A Patient exists in iTrust2
	And An HCP exists in iTrust2
	And The patient choose to request a medical appointment
	When I log in as hcp
	And The HCP navigates to the Appointment Requests page
	And The HCP selects the appointment request 
	And The HCP selects to approve the selected appointment request
	Then The appointment request is moved into the upcoming medical appointment column
	And The HCP behavior is logged on the iTrust2 homepage

Examples:
	| type							| hcp				| date			| time 		| comments 		|
	| General Checkup				| hcp		 		| 10/31/2040	| 10:00 AM	| My brain hurt	|
