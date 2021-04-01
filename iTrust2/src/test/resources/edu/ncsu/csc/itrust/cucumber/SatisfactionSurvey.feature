Feature: View and complete satisfaction surveys
	Patients and HCPs/Opthamologists should be able to view satisfaction surveys after completing an appointment
	So that general HCPs/Opthamologists and admins can review their performance

Scenario Outline: Patient has no surveys to complete
	Given A Patient exists in iTrust2
	When I log in as patient
	When I navigate to the Manage Manage Surveys page
	Then <text> is displayed for satisfaction surveys

Examples:
	| text 								|
	| No surveys available to complete.	|

Scenario Outline: Complete satisfaction survey
	Given A Patient exists in iTrust2
	And An HCP exists in iTrust2
	When I log in as patient
	When I navigate to the Manage Appointment Requests page
	And I choose to complete a survey for a medical appointment with timeWaitedWaitingRoom <timeWaitedWaitingRoom>, timeWaitedExaminationRoom <timeWaitedExaminationRoom>, 
  satisfiedOfficeVisit <satisfiedOfficeVisit>, satisfiedTreatment <satisfiedTreatment>, and notes <notes>
	Then The appointment request with timeWaitedWaitingRoom <timeWaitedWaitingRoom>, timeWaitedExaminationRoom <timeWaitedExaminationRoom>,
  satisfiedOfficeVisit <satisfiedOfficeVisit>, satisfiedTreatment <satisfiedTreatment>, and notes <notes> is submitted successfully

Examples:
	| timeWaitedWaitingRoom							| timeWaitedExaminationRoom				| satisfiedOfficeVisit			| satisfiedTreatment 		| notes 						|
	| 0				| 0 		        | 6	| 6	| My brain still hurt					|
  
  
Scenario Outline: Complete satisfaction survey
	Given A Patient exists in iTrust2
	And An HCP exists in iTrust2
	When I log in as patient
	When I navigate to the Manage Appointment Requests page
	And I choose to complete a survey for a medical appointment with timeWaitedWaitingRoom <timeWaitedWaitingRoom>, timeWaitedExaminationRoom <timeWaitedExaminationRoom>, 
  satisfiedOfficeVisit <satisfiedOfficeVisit>, satisfiedTreatment <satisfiedTreatment>, and notes <notes>
	Then The appointment request with timeWaitedWaitingRoom <timeWaitedWaitingRoom>, timeWaitedExaminationRoom <timeWaitedExaminationRoom>,
  satisfiedOfficeVisit <satisfiedOfficeVisit>, satisfiedTreatment <satisfiedTreatment>, and notes <notes> is not submitted and the form remains the same for editing.

Examples:
	| timeWaitedWaitingRoom							| timeWaitedExaminationRoom				| satisfiedOfficeVisit			| satisfiedTreatment 		| notes 						|
	| -5				| -5 		        | A	| B	| My brain still hurt					|

Scenario Outline: Patient Reviews satisfaction survey
	Given A Patient exists in iTrust2
	And An HCP exists in iTrust2
	When I log in as patient
  And The patient has been to a medical appointment
  And The patient has completed a satisfaction survey
	When I navigate to the Manage Surveys page
	Then The patient can review a survey with timeWaitedWaitingRoom <timeWaitedWaitingRoom>, timeWaitedExaminationRoom <timeWaitedExaminationRoom>, 
  satisfiedOfficeVisit <satisfiedOfficeVisit>, satisfiedTreatment <satisfiedTreatment>, and notes <notes>

Examples:
	| timeWaitedWaitingRoom							| timeWaitedExaminationRoom				| satisfiedOfficeVisit			| satisfiedTreatment 		| notes 						|
	| 0				| 0 		        | 6	| 6	| My brain still hurt					|

Scenario Outline: HCP Reviews satisfaction survey
	Given A Patient exists in iTrust2
	And An HCP exists in iTrust2
	When I log in as HCP
  And The patient has been to a medical appointment
  And The patient has completed a satisfaction survey
	When I navigate to the Manage Surveys page
	Then The I can review a survey with timeWaitedWaitingRoom <timeWaitedWaitingRoom>, timeWaitedExaminationRoom <timeWaitedExaminationRoom>, 
  satisfiedOfficeVisit <satisfiedOfficeVisit>, satisfiedTreatment <satisfiedTreatment>, and notes <notes>

Examples:
	| timeWaitedWaitingRoom							| timeWaitedExaminationRoom				| satisfiedOfficeVisit			| satisfiedTreatment 		| notes 						|
	| 0				| 0 		        | 6	| 6	| My brain still hurt					|
	
Scenario Outline: Approve appointment request as an HCP
	Given A Patient exists in iTrust2
	And An HCP exists in iTrust2
	And The patient has requested a medical appointment with type <type>, HCP <hcp>, date <date>, time <time>, and comments <comments>
	When I log in as hcp
	And The HCP navigates to the Appointment Requests page
	And The HCP selects the appointment request with type <type>, HCP <hcp>, date <date>, time <time>, and comments <comments>
	And The HCP selects to approve the selected appointment request
	Then The appointment request with type <type>, HCP <hcp>, date <date>, time <time>, and comments <comments> is moved into the upcoming medical appointment column
	And The HCP behavior is logged on the iTrust2 homepage

Examples:
	| type							| hcp				| date			| time 		| comments 		|
	| General Checkup				| hcp		 		| 10/31/2040	| 10:00 AM	| My brain hurt	|
