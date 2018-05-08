package demo.teamwork.aquidigital.com.common.generate_models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class Project {

	@SerializedName("replyByEmailEnabled")
	public abstract boolean replyByEmailEnabled();

	@SerializedName("endDate")
	public abstract String endDate();

	@SerializedName("created-on")
	public abstract String createdOn();

	@SerializedName("announcementHTML")
	public abstract String announcementHTML();

	@SerializedName("description")
	public abstract String description();

	@SerializedName("overview-start-page")
	public abstract String overviewStartPage();

	@SerializedName("boardData")
	public abstract BoardData boardData();

	@SerializedName("starred")
	public abstract boolean starred();

	@SerializedName("logo")
	public abstract String logo();

	@SerializedName("company")
	public abstract Company company();

	@SerializedName("id")
	public abstract String id();

	@SerializedName("announcement")
	public abstract String announcement();

	@SerializedName("tasks-start-page")
	public abstract String tasksStartPage();

	@SerializedName("start-page")
	public abstract String startPage();

	@SerializedName("notifyeveryone")
	public abstract boolean notifyeveryone();

	@SerializedName("filesAutoNewVersion")
	public abstract boolean filesAutoNewVersion();

	@SerializedName("subStatus")
	public abstract String subStatus();

	@SerializedName("tags")
	public abstract List<Object> tags();

	@SerializedName("privacyEnabled")
	public abstract boolean privacyEnabled();

	@SerializedName("isProjectAdmin")
	public abstract boolean isProjectAdmin();

	@SerializedName("defaultPrivacy")
	public abstract String defaultPrivacy();

	@SerializedName("last-changed-on")
	public abstract String lastChangedOn();

	@SerializedName("defaults")
	public abstract Defaults defaults();

	@SerializedName("name")
	public abstract String name();

	@SerializedName("show-announcement")
	public abstract boolean showAnnouncement();

	@SerializedName("harvest-timers-enabled")
	public abstract boolean harvestTimersEnabled();

	@SerializedName("category")
	public abstract Category category();

	@SerializedName("integrations")
	public abstract Integrations integrations();

	@SerializedName("startDate")
	public abstract String startDate();

	@SerializedName("status")
	public abstract String status();

	public static TypeAdapter<Project> typeAdapter(Gson gson) {
		return new AutoValue_Project.GsonTypeAdapter(gson);
	}
}