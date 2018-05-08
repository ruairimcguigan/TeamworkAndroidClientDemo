package demo.teamwork.aquidigital.com.common.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Response{

	@SerializedName("STATUS")
	public abstract String status();

	@SerializedName("projects")
	public abstract List<Project> projects();

	public static TypeAdapter<Response> typeAdapter(Gson gson) {
		return new AutoValue_Response.GsonTypeAdapter(gson);
	}
}