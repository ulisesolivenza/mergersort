package org.java;


import org.java.esort.*;
import org.java.esort.model.*;
import org.java.esort.MemoryManager;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ulises on 20/02/16.
 */
public class ChunkenizerTest {

    private BigFile inFile;
    private Chunkenizer chunkenizer;

    @Before
    public void setUp() throws Exception {
        inFile = new BigFile("src/test/resources/file.txt");
        chunkenizer = new Chunkenizer();
    }

    @Test
    public void testMoreChunks() throws Exception {
        MemoryManager memoryManager = mock(MemoryManager.class);

        when(memoryManager.availableMemory()).thenReturn(MemoryManager.MEGABYTE / 2);

        MergeSortInfoProvider mergeSortInfoProvider = new MergeSortInfoProvider(memoryManager);
        MergeSortInfo mergeSortInfo = mergeSortInfoProvider.buildMergeInfo(inFile, mock(Path.class));


        Chunks chunkList = chunkenizer.chunkenize(new SortBigFile(inFile, mergeSortInfo), Files.createTempDirectory("chunks"));
        assertEquals(mergeSortInfo.chunks(), chunkList.size());


    }

    @Test
    public void testOneChunks() throws Exception {

        MergeSortInfo mergeSortInfo = new MergeSortInfo(1, inFile.size(), Arrays.asList(new PassInfo(1, 1)), mock(Path.class));


        Chunks chunkList = chunkenizer.chunkenize(new SortBigFile(inFile, mergeSortInfo), Files.createTempDirectory("chunks"));
        assertEquals(mergeSortInfo.chunks(), chunkList.size());

    }
}
