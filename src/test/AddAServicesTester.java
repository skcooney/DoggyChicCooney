package test;

import controller.ServiceHelper;

import model.Services;



public class AddAServicesTester {

	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ServiceHelper servicehelp = new ServiceHelper();
			Services Basic = new Services("Basic");
			servicehelp.insertServices(Basic);
			
			Services Premium = new Services("Premium");
			servicehelp.insertServices(Premium);

			Services Super = new Services("Super");
			servicehelp.insertServices(Super);
			
			
			//ClassrCustomeroom ClassroomToDelete = customerhelp.getClassroomById(1);
			//Customerhelp.deleteClassroom(CustomerToDelete);


		}

		
	}


