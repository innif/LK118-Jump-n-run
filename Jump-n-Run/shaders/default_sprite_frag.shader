#version 330 core

in DATA {
	vec2 uvs;
} fs_in;

uniform sampler2D sampler;

void main()
{
	gl_FragColor = texture(sampler, fs_in.uvs);
}