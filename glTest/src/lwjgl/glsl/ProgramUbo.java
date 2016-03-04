/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwjgl.glsl;

import com.jogamp.opengl.GL3;

/**
 *
 * @author gbarbieri
 */
public class ProgramUbo extends glsl.GLSLProgramObject {

    public ProgramUbo(GL3 gl3, String shadersFilepath, String vertexShader, String fragmentShader) {

        super(gl3, shadersFilepath, vertexShader, fragmentShader);

        int Ubi = gl3.glGetUniformBlockIndex(getProgramId(), "ubo");
        gl3.glUniformBlockBinding(getProgramId(), Ubi, 0);
    }

}
