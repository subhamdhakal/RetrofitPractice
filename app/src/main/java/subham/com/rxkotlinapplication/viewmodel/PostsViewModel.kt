package subham.com.rxkotlinapplication.viewmodel

import subham.com.rxkotlinapplication.database.PostsModel

class PostsViewModel(var postsModel: PostsModel) {
    fun getUserId(): String {
        return postsModel.userId
    }

    fun getId(): String {
        return postsModel.id
    }

    fun getTitle(): String {
        return postsModel.title
    }

    fun getBody(): String {
        return postsModel.body
    }
}