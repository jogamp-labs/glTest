/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glTest.solutions;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.util.GLBuffers;
import glTest.framework.BufferUtils;
import glTest.framework.RingBuffer;
import glm.vec._4.Vec4;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 *
 * @author GBarbieri
 */
public abstract class DynamicStreamingSolution extends Solution {

    protected IntBuffer uniformBuffer;
    protected IntBuffer vertexBuffer;
    protected int program;
    protected IntBuffer vao;
    protected int startDestOffset;
    protected ByteBuffer constants;
    protected int vertexCount;
    protected final String SHADER_SRC = "streaming";
    protected RingBuffer particleRingBuffer;

    @Override
    public boolean init(GL4 gl4) {

        uniformBuffer = GLBuffers.newDirectIntBuffer(1);
        vertexBuffer = GLBuffers.newDirectIntBuffer(1);
        vao = GLBuffers.newDirectIntBuffer(1);
        constants = GLBuffers.newDirectByteBuffer(Vec4.SIZE);

        return true;
    }

    public abstract void render(GL4 gl4, ByteBuffer vertices);

    @Override
    public boolean shutdown(GL4 gl4) {

        BufferUtils.destroyDirectBuffer(vao);
        BufferUtils.destroyDirectBuffer(vertexBuffer);
        BufferUtils.destroyDirectBuffer(uniformBuffer);
        BufferUtils.destroyDirectBuffer(constants);
        
        return true;
    }

    @Override
    public abstract String getName();

    @Override
    public String getProblemName() {
        return "DynamicStreaming";
    }

}
