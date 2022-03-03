<template>
<div>
  {{book.id}}
  {{ book.name }}
</div>
</template>

<script>
export default {
  name: "BackstageBodyListItem",
  props: ['book']
}
</script>

<style scoped>

</style>