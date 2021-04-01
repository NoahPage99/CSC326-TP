#Author laagamai

Feature: Add a User
	As an Admin
	I want to add a new user 
	So that someone new can use iTrust
	
Scenario: Add new user
Given An Admin exists in iTrust2
When I log in as admin
When I navigate to the Add User page
When I fill in the values in the Add User form
Then The user is created successfully
And The new user can login

Scenario: Add new user
Given An Admin exists in iTrust2
When I log in as admin
When I navigate to the Add User page
When I fill in the values in the Add User form with two valid roles
Then The user is created successfully
And The new user can login
And The new user has both roles

Scenario: Invalid Add User: Extra Roles
Given An Admin exists in iTrust2
When I log in as admin
When I navigate to the Add User page
When I fill in invalid roles in the Add User form
Then The user is not created successfully

Scenario: Invalid Add User: Missing Roles
Given An Admin exists in iTrust2
When I log in as admin
When I navigate to the Add User page
When I fill in invalid roles in the Add User form
Then The user is not created successfully

Feature: Add a User Role Ophthalmologist
	As an Admin
	I want to add a new user role: ROLE_OPHTHALMOLOGIST 
	So that this role is an HCP and is able to do appointments and office visits. 
	
Scenario: Add new user
Given An Admin exists in iTrust2
When I log in as admin
When I navigate to the Add User page
When I fill in the values in the Add User form
When I clck role ROLE_HCP and ROLE_OPHTHALMOLOGIST
Then The user is created successfully
And The new user can login	

Scenario: Invalid Role: Extra Roles for new role
Given An Admin exists in iTrust2
When I log in as admin
When I navigate to the Add User page
When I fill in invalid roles for the Ophthalmologist role
Then The user is not created successfully