package org.java;

import org.java.esort.model.Chunk;
import org.java.esort.model.TFile;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ulises on 18/02/16.
 */
public class ChunkTest {

    private TFile outFile;
    private Path inFile;
    private Path checkFile;
    private Chunk chunk;

    @Before
    public void setUp() throws Exception {
        inFile = Paths.get("src/test/resources/lineReaderTest.txt");
        chunk = new Chunk(inFile, 1 );
        checkFile = Paths.get("src/test/resources/testChunkSortedTest.txt");
        outFile = new TFile("src/test/resources/tmpWriterTest.txt");

    }

    @Test
    public void testReadLine() throws Exception {
       /* Chunk sortedChunk = chunk.sort(outFile);
        assertEquals(chunk.chunkgroup(), sortedChunk.chunkgroup());

        byte[] in = Files.readAllBytes(sortedChunk.path());
        byte[] out = Files.readAllBytes(checkFile);

        sortedChunk.delete();

        assertTrue(Arrays.equals(in, out));*/
    }
}
