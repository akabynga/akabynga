package com.akabynga.multithreading.concurrenthashmap;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class LetterCounter {

    private final int subtaskCount;

    public LetterCounter(final int subtaskCount) {
        this.subtaskCount = subtaskCount;
    }

    public final Map<Character, Integer> count(final String input) {
        final Map<Character, Integer> accumulator = createAccumulator();
        final Stream<Subtask> subtasks = createSubtasks(accumulator, input);
        execute(subtasks);
        return accumulator;
    }

    protected abstract Map<Character, Integer> createAccumulator();

    protected abstract void execute(final Stream<Subtask> subtasks);

    private Stream<Subtask> createSubtasks(final Map<Character, Integer> accumulator, final String input) {
        final int subtaskCharCount = findSubtaskCharCount(input);
        return IntStream.range(0, subtaskCount).mapToObj(i -> createSubtask(accumulator, input, subtaskCharCount, i));
    }

    private static Subtask createSubtask(final Map<Character, Integer> accumulator,
                                         final String input,
                                         final int charCount,
                                         final int index) {
        final int start = index * charCount;
        final int end = Math.min((index + 1) * charCount, input.length());
        return new Subtask(accumulator, input, start, end);
    }

    private int findSubtaskCharCount(final String input) {
        return (int) Math.ceil((double) input.length() / subtaskCount);
    }

    protected static final class Subtask {
        private final Map<Character, Integer> accumulator;
        private final String input;
        private final int start;
        private final int end;

        public Subtask(final Map<Character, Integer> accumulator,
                       final String input,
                       final int start,
                       final int end) {
            this.accumulator = accumulator;
            this.input = input;
            this.start = start;
            this.end = end;
        }

        public void execute() {
            IntStream.range(start, end)
                    .map(input::codePointAt)
                    .filter(Character::isLetter)
                    .map(Character::toLowerCase)
                    .forEach(this::accumulate);
        }

        private void accumulate(final int codePoint) {
            accumulator.merge((char) codePoint, 1, Integer::sum);
        }
    }
}
