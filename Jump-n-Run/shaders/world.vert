#version 330 core

layout (location = 0) in vec4 position;
layout (location = 1) in vec2 texCoords;
layout (location = 2) in float tid;

out DATA {
	vec2 uvs;
	float tid;
} vs_out;


uniform vec2 worldOffset;
uniform vec2 screenSize;

void main()
{
	vs_out.uvs = texCoords;
	vs_out.tid = tid;
	gl_Position = ((position - vec4(worldOffset, 0.0, 0.0)) / vec4(screenSize / 2.0f, 1.0, 1.0)) - vec4(1.0, 1.0, 0.0, 0.0);
}