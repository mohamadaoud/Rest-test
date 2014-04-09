package controllers;

import java.util.*;
import com.avaje.ebean.Ebean;
import models.Patients;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class PatientController extends Controller {
	
	public static Result create() {
		
		Patients patient = Form.form(Patients.class).bindFromRequest().get();

		Ebean.save(patient);

		return ok();
			
	}
	
	public static Result get(int id) {
		return ok(Json.toJson(Ebean.find(Patients.class, id)));
	}
	
	public static Result getAll() {
		List<Patients> patients = Ebean.find(Patients.class).findList();
		return ok(Json.toJson(patients));
	}
	
	public static Result update(int id) {
		Patients patient = Form.form(Patients.class).bindFromRequest().get();
		patient.id = id;

		Ebean.update(patient);

		return ok();
	}

	public static Result delete(int id) {
		Ebean.delete(Ebean.find(Patients.class, id));

		return ok();
	}

}
