package com.hcl.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("proj")

public class Project {
	@Value("12345")
	private int projectId;
	@Value("Project4")
	private String projectName;
}
