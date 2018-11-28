package subham.com.rxkotlinapplication.viewmodel

import subham.com.rxkotlinapplication.database.CommentsModel

class CommentsViewModel(var commentsModel: CommentsModel) {
    fun getPostsId(): String {
        return commentsModel.postId
    }

    fun getId(): String {
        return commentsModel.id
    }

    fun getName(): String {
        return commentsModel.name
    }

    fun getEmail(): String {
        return commentsModel.email
    }

    fun getBody(): String {
        return commentsModel.body
    }
}