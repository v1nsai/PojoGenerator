# PojoGenerator
A no-frills POJO generator.  Uses randomized data to quickly create new instances of any given POJO object.

## Currently generates data for:
* Primitives (and wrapper classes)
* User-defined POJOs
* Nested user-defined POJOs

## Known-issues and limitations
* Unable to automatically handle Collections due to type erasure at runtime.  Use a loop to generate your objects with PojoGenerator individually instead.